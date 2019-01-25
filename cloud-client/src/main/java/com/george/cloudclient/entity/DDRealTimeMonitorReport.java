package com.george.cloudclient.entity;

import java.io.Serializable;

public class DDRealTimeMonitorReport implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private long icbc;
	private long boc;
	private long ccb;
	private long abc;
	private long psbc;
	private long cmb;
	private long other;
	private long bocm;
	private long evrb;
	private long cgb;
	private long cmbc;
	private long spdb;
	private long cib;
	private long pab;
	private long szrcb;
	private long bjcb;
	private long boh;
	private long hua;
	private long czb;
	
	public long getIcbc() {
		return icbc;
	}

	public void setIcbc(long icbc) {
		this.icbc = icbc;
	}

	public long getBoc() {
		return boc;
	}

	public void setBoc(long boc) {
		this.boc = boc;
	}

	public long getCcb() {
		return ccb;
	}

	public void setCcb(long ccb) {
		this.ccb = ccb;
	}

	public long getAbc() {
		return abc;
	}

	public void setAbc(long abc) {
		this.abc = abc;
	}

	public long getPsbc() {
		return psbc;
	}

	public void setPsbc(long psbc) {
		this.psbc = psbc;
	}

	public long getCmb() {
		return cmb;
	}

	public void setCmb(long cmb) {
		this.cmb = cmb;
	}

	public long getOther() {
		return other;
	}

	public void setOther(long other) {
		this.other = other;
	}

	public long getBocm() {
		return bocm;
	}

	public void setBocm(long bocm) {
		this.bocm = bocm;
	}

	public long getEvrb() {
		return evrb;
	}

	public void setEvrb(long evrb) {
		this.evrb = evrb;
	}

	public long getCgb() {
		return cgb;
	}

	public void setCgb(long cgb) {
		this.cgb = cgb;
	}

	public long getCmbc() {
		return cmbc;
	}

	public void setCmbc(long cmbc) {
		this.cmbc = cmbc;
	}

	public long getSpdb() {
		return spdb;
	}

	public void setSpdb(long spdb) {
		this.spdb = spdb;
	}

	public long getCib() {
		return cib;
	}

	public void setCib(long cib) {
		this.cib = cib;
	}

	public long getPab() {
		return pab;
	}

	public void setPab(long pab) {
		this.pab = pab;
	}

	public long getSzrcb() {
		return szrcb;
	}

	public void setSzrcb(long szrcb) {
		this.szrcb = szrcb;
	}

	public long getBjcb() {
		return bjcb;
	}

	public void setBjcb(long bjcb) {
		this.bjcb = bjcb;
	}

	public long getBoh() {
		return boh;
	}

	public void setBoh(long boh) {
		this.boh = boh;
	}

	public long getHua() {
		return hua;
	}

	public void setHua(long hua) {
		this.hua = hua;
	}

	public long getCzb() {
		return czb;
	}

	public void setCzb(long czb) {
		this.czb = czb;
	}

	@Override
    public String toString() 
	{
        return "DDRealTimeMonitorReport [" + 
                "  icbc=" + icbc +
                ", boc=" + boc + 
                ", ccb=" + ccb + 
                ", abc=" + abc + 
                ", psbc=" + psbc + 
                ", cmb=" + cmb + 
                ", other=" + other + 
                ", bocm=" + bocm + 
                ", evrb=" + evrb + 
                ", cgb=" + cgb + 
                ", cmbc=" + cmbc + 
                ", spdb=" + spdb + 
                ", cib=" + cib + 
                ", pab=" + pab + 
                ", szrcb=" + szrcb + 
                ", bjcb=" + bjcb + 
                ", boh=" + boh + 
                ", hua=" + hua + 
                ", czb=" + czb + 
                ']';
    }
}
