package com.xgc.demo.controller;

import java.sql.Connection;  
import java.sql.DatabaseMetaData;  
import java.sql.DriverManager;  
import java.sql.ResultSet;  
import java.sql.SQLException;  

public class DatabaseMetaDateApplication {

	private DatabaseMetaData dbMetaData = null;  
    private Connection con = null;  
  
  
    public DatabaseMetaDateApplication() {  
        this.getDatabaseMetaData();  
    }  
  
  
    private void getDatabaseMetaData() {  

        try {  
            if (dbMetaData == null) {  
                Class.forName("com.mysql.jdbc.Driver");  
                String url = "jdbc:mysql://localhost:3306/androiddb";  
                String user = "root";  
                String password = "123456";  
                con = DriverManager.getConnection(url, user, password);  
                dbMetaData = con.getMetaData();  
            }  
        } catch (ClassNotFoundException e) {  
            e.printStackTrace();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }  
    /** 
     * ��ø��û���������б� 
     */  
    public void getAllTableList(String schemaName) {  
        try {  
            // table type. Typical types are "TABLE", "VIEW", "SYSTEM TABLE", "GLOBAL TEMPORARY", "LOCAL TEMPORARY", "ALIAS", "SYNONYM".  
            String[] types = { "TABLE" };  
            ResultSet rs = dbMetaData.getTables(null, schemaName, "%", types);  
            while (rs.next()) {  
                String tableName = rs.getString("TABLE_NAME");  //����  
                String tableType = rs.getString("TABLE_TYPE");  //������  
                String remarks = rs.getString("REMARKS");       //��ע  
                System.out.println(tableName + "-" + tableType + "-" + remarks);  
            }  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }  
    /**   
     * ������ݿ������з�������   
     */    
    public void getAllSchemas(){  
        try{  
            ResultSet rs = dbMetaData.getSchemas();    
            while (rs.next()){     
                String tableSchem = rs.getString("TABLE_SCHEM");     
                System.out.println(tableSchem);     
            }     
        } catch (SQLException e){  
            e.printStackTrace();     
        }     
    }    
    /** 
     * ���һ�����������Ϣ 
     */  
    public void getAllPrimaryKeys(String schemaName, String tableName) {  
        try{  
            ResultSet rs = dbMetaData.getPrimaryKeys(null, schemaName, tableName);  
            while (rs.next()){  
                String columnName = rs.getString("COLUMN_NAME");//����  
                short keySeq = rs.getShort("KEY_SEQ");//���к�(������ֵ1��ʾ��һ�е�������ֵ2���������ڵĵڶ���)  
                String pkName = rs.getString("PK_NAME"); //��������    
                System.out.println(columnName + "-" + keySeq + "-" + pkName);     
            }  
        }catch (SQLException e){  
            e.printStackTrace();  
        }  
    }  
    /** 
     * ��ñ����ͼ�е���������Ϣ 
     */  
    public void getTableColumns(String schemaName, String tableName) {  
           
        try{     
                  
            ResultSet rs = dbMetaData.getColumns(null, schemaName, tableName, "%");              
            while (rs.next()){  
                    String tableCat = rs.getString("TABLE_CAT");//��Ŀ¼������Ϊ�գ�                  
                    String tableSchemaName = rs.getString("TABLE_SCHEM");//��ļܹ�������Ϊ�գ�     
                    String tableName_ = rs.getString("TABLE_NAME");//����  
                    String columnName = rs.getString("COLUMN_NAME");//����  
                    int dataType = rs.getInt("DATA_TYPE"); //��Ӧ��java.sql.Types����     
                    String dataTypeName = rs.getString("TYPE_NAME");//java.sql.Types����   ����  
                    int columnSize = rs.getInt("COLUMN_SIZE");//�д�С  
                    int decimalDigits = rs.getInt("DECIMAL_DIGITS");//С��λ��  
                    int numPrecRadix = rs.getInt("NUM_PREC_RADIX");//������ͨ����10��2��  
                    int nullAble = rs.getInt("NULLABLE");//�Ƿ�����Ϊnull  
                    String remarks = rs.getString("REMARKS");//������  
                    String columnDef = rs.getString("COLUMN_DEF");//Ĭ��ֵ  
                    int sqlDataType = rs.getInt("SQL_DATA_TYPE");//sql��������  
                    int sqlDatetimeSub = rs.getInt("SQL_DATETIME_SUB");   //SQL����ʱ���?  
                    int charOctetLength = rs.getInt("CHAR_OCTET_LENGTH");   //char���͵����е�����ֽ���  
                    int ordinalPosition = rs.getInt("ORDINAL_POSITION");  //�����е���������1��ʼ��  
                      
                    /** 
                     * ISO��������ȷ��ĳһ�е�Ϊ���ԡ� 
                     * ��---����ò������԰�����ֵ; 
                     * ��---����������ܰ�����ֵ 
                     * ���ַ���---�������Ϊ������δ֪�� 
                     */  
                    String isNullAble = rs.getString("IS_NULLABLE");  
                      
                    /** 
                     * ָʾ�����Ƿ����Զ����� 
                     * ��---����������Զ����� 
                     * ��---��������Զ������� 
                     * ���ִ�---�������ȷ�����Ƿ� 
                     * �����Զ������Ĳ�����δ֪ 
                     */  
                    String isAutoincrement = rs.getString("IS_AUTOINCREMENT");     
                      
                    System.out.println(tableCat + "-" + tableSchemaName + "-" + tableName_ + "-" + columnName + "-"    
                            + dataType + "-" + dataTypeName + "-" + columnSize + "-" + decimalDigits + "-" + numPrecRadix     
                            + "-" + nullAble + "-" + remarks + "-" + columnDef + "-" + sqlDataType + "-" + sqlDatetimeSub     
                            + charOctetLength + "-" + ordinalPosition + "-" + isNullAble + "-" + isAutoincrement + "-");     
                }     
            } catch (SQLException e){  
                e.printStackTrace();     
            }  
    }  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 DatabaseMetaDateApplication metaData = new DatabaseMetaDateApplication(); 
		 metaData.getTableColumns(null,"menu");
	}

}
