package com.scloudpay.testframe.admin.sysmgr.entity; 

public class SysDictType   {

    private long id;
    
    private String typeCode;
    
    private int typeKind;
    
    private String typeName;
    
    private String remark;

    public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public long getId(){
       return id;
    }
    public void setId(long id){
         this.id = id;
    }
    
    public String getTypeCode(){
       return typeCode;
    }
    public void setTypeCode(String typeCode){
         this.typeCode = typeCode;
    }
    
    public int getTypeKind(){
       return typeKind;
    }
    public void setTypeKind(int typeKind){
         this.typeKind = typeKind;
    }
    
    public String getTypeName(){
       return typeName;
    }
    public void setTypeName(String typeName){
         this.typeName = typeName;
    }
    
  
}

