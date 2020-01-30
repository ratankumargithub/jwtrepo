package p1;

public class Test {

	public static void main(String[] args) {
		
		
		JwtUtil jwt=new JwtUtil();
		
		UserDetails ud=new UserDetails("ram");
		
		String t=jwt.generateToken(ud);
	
		System.out.println(t);
		
		boolean f=jwt.validateToken(t,ud);
		
		
		System.out.println(f);
	}

}
