package HomeLyf.Payload;

public class QDTAS_UserChangeTempPasswordPayload {
	
	public static String email;
	public static String oldp;
	public static String newp;
	public static String getEmail() {
		return email;
	}	
	public static void setEmail(String email) {
		QDTAS_UserChangeTempPasswordPayload.email = email;
	}
	public static String getOldp() {
		return oldp;
	}
	public static void setOldp(String oldp) {
		QDTAS_UserChangeTempPasswordPayload.oldp = oldp;
	}
	public static String getNewp() {
		return newp;
	}
	public static void setNewp(String newp) {
		QDTAS_UserChangeTempPasswordPayload.newp = newp;
	}
}
