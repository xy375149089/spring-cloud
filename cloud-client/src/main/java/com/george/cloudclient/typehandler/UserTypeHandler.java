package com.george.cloudclient.typehandler;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.george.cloudclient.entity.User;

import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;

public class UserTypeHandler extends BaseTypeHandler<List<User>>{
	
	private static final String TYP_USER_OBJ = "TYP_USER_RESULT";
	private static final String TYP_USER_TAB = "TAB_USER_RESULT";

	private static final Logger logger = LoggerFactory.getLogger(UserTypeHandler.class);

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, List<User> parameter, JdbcType jdbcType)
			throws SQLException {
		if (null != parameter) {
			Connection conn = getOriginalConnection(ps.getConnection());
			ARRAY array = getArray(conn, TYP_USER_OBJ, TYP_USER_TAB, parameter);
			ps.setArray(i, array);
		}
	}

	public static ARRAY getArray(Connection conn, String oracleTypeObject, String oracleTypeTable,
			List<User> parameters) throws SQLException {
		ARRAY array = null;
		ArrayDescriptor desc = ArrayDescriptor.createDescriptor(oracleTypeTable, conn);
		STRUCT[] structArr = new STRUCT[parameters.size()];
		if (null != parameters && !parameters.isEmpty()) {
			StructDescriptor typeObjDesc = new StructDescriptor(oracleTypeObject, conn);
			for (int i = 0; i < parameters.size(); i++) {
				User user = parameters.get(i);
				
				Object[] result = { 
						user.getuName(),
						user.getuSex()
						};
				structArr[i] = new STRUCT(typeObjDesc, conn, result);
			}
			array = new ARRAY(desc, conn, structArr);
		} else {
			array = new ARRAY(desc, conn, structArr);
		}
		return array;
	}

	private Connection getOriginalConnection(Connection con) {
		try {
			return con.getMetaData().getConnection();
		} catch (Exception e) {
			logger.error("get getOriginalConnection failed :{}", e);
		}
		return con;
	}

	@Override
	public List<User> getNullableResult(ResultSet arg0, String arg1) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getNullableResult(ResultSet arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getNullableResult(CallableStatement arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
