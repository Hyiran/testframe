package com.scloudpay.testframe.admin.sysmgr.entity; 

import java.io.Serializable;

public class SysDictItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7133174674984231576L;

	private long id;
    
    private String itemCode;

    private String itemName;
    
    private int sortIndex;
    
    private String typeCode;
    
    private String className;
    
    private String remark;
    
    public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public long getId(){
       return id;
    }
    public void setId(long id){
         this.id = id;
    }
    
    public String getItemCode(){
       return itemCode;
    }
    public void setItemCode(String itemCode){
         this.itemCode = itemCode;
    }
    
    public String getItemName(){
       return itemName;
    }
    public void setItemName(String itemName){
         this.itemName = itemName;
    }
    
    public int getSortIndex(){
       return sortIndex;
    }
    public void setSortIndex(int sortIndex){
         this.sortIndex = sortIndex;
    }
    
    public String getTypeCode(){
       return typeCode;
    }
    public void setTypeCode(String typeCode){
         this.typeCode = typeCode;
    }
    
  
}

