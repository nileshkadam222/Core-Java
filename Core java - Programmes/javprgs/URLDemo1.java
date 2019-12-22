class URLDemo1 
{	
	long d;
	public static void main(String args[])throws Exception
	{
		URL u=new URL("http://localhost:8080/Radha/ShowTime.jsp");
		URLConnection uc=u.openConnection();
		HttpURLConnection huc=(HttpURLConnection)uc;
		Date d=new Date(uc.getDate());
		System.out.println("File Name ="+u.getFile());
		System.out.println("Host Name="+u.getHost());
		System.out.println("Path Name="+u.getPath());
		System.out.println("Port Name="+u.getPort());
		System.out.println("Protocol Name="+u.getProtocol());
		System.out.println("Reference Name="+u.getRef());
		System.out.println("User Info="+u.getUserInfo());
		System.out.println("Content Name="+u.getContent());
		System.out.println("Authority Name="+u.getAuthority());
		System.out.println("Content Type="+uc.getContentType());
		System.out.println("Length="+uc.getContentLength());
		System.out.println("Expiration Date= "+uc.getExpiration());
		System.out.println("Encoding Type=  "+uc.getContentEncoding());
		System.out.println("Last Modified Date=  "+uc.getLastModified());
		System.out.println("Date="+d.toString());
		System.out.println("Request Method=  "+huc.getRequestMethod());
		System.out.println("Response Message=  "+huc.getResponseMessage());
		System.out.println("Response Code=  "+huc.getResponseCode());
	}
}	



