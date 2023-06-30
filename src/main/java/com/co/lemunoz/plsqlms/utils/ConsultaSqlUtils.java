package com.co.lemunoz.plsqlms.utils;

import java.util.Arrays;
import java.util.List;

import lombok.Data;

@Data
public class ConsultaSqlUtils {
	
	public static List<String> UPDATE = Arrays.asList("INSERT", "UPDATE", "MERGE", "DELETE", "TRUNCATE");
	
	public static List<String> EXECUTE = Arrays.asList("CREATE", "ALTER`", "DROP", "RENAME", "SET", "GRANT", "REVOKE", "COMMIT", "ROLLBACK");

}
