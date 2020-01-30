package p1;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import com.fasterxml.jackson.databind.deser.ValueInstantiator.Gettable;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {

	public static String SECRET_KEY="secret";
	
	public String generateToken(UserDetails userDetails){
		String token="";
		
		Map<String,Object> claims=new HashMap<>();
		
		claims.put("one", "Account");
		claims.put("two", "Apple");
		claims.put("three", "Mango");
		token=createToken(claims,userDetails.getUsername());
		
		return token;
	}
	
	
	private String createToken(Map<String, Object> claims,String subject){
		
		String token="";
		
		
		token = Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() *1000 *60 *60)).signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();		
		
		return token;
	}
	
	public boolean validateToken(String token,UserDetails userDetails){
		boolean flag=false;
		
		final String username=extractUserName(token);
		
		if(username.equals(userDetails.getUsername()) && !isTokenExpired(token)) 
			flag=true;
		
		
		
		return flag;
	}


	private boolean isTokenExpired(String token) {
		boolean flag=false;
		
		flag= extractExpiration(token).before(new Date());
		
		
		return flag;
	}


	private Date extractExpiration(String token) {
		
		Claims claims=extractAllClaims(token);
		
		return claims.getExpiration();
	}


	
	
	

	private String extractUserName(String token) {
		Claims claims=extractAllClaims(token);
		
		return claims.getSubject();
		
		
	}
	
	private Claims extractAllClaims(String token){
		
		
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
