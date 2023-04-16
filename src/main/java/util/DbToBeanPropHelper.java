package util;

import java.util.Date;

public class DbToBeanPropHelper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "ApplicantNo,Firstname,Middlename,Lastname,Sex,Suffix,BirthDate,Age,Nationality,CivilStatus,AddHouseNo,AddStreet,AddBarangay,AddCity,AddProvince,Religion,RegistrationDate,Image";
		System.out.println(convertToProp(str));
		System.out.println(new Date());
	}

	private static String convertToProp(String columns) {
		String[] colArr = columns.split(",");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < colArr.length; i++) {
			String camelC = toCamelCase(colArr[i]);
			sb.append("private String " + camelC + ";\n");
		}
		return sb.toString();
	}

	public static String toCamelCase(String columName) {
		return columName.substring(0, 1).toLowerCase() + columName.substring(1);
	}
}
