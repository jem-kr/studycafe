package mypkg.utility;

import java.security.MessageDigest;

//해시값을 반환하는 역할 = 특정한 입력값, 이메일 값에 해시를 적용한 값을 반환해서 이용..
//악의적인 공격을 막기 위해 SHA256클래스 작성
public class SHA256 {
	public static String getSHA256(String input) {

		StringBuffer result = new StringBuffer();

		try {
			//실제로 사용자가 입력한 값을 SHA256으로 알고리즘을 적용해줌
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			//salt는 보안을 위해서 작성..
			byte[] salt = "Hello! This is Salt.".getBytes();

			digest.reset();

			digest.update(salt);
			//해시를 적용한 값을 캐릭터 변수에 담아주고 문자열 형태로 만들어줌
			byte[] chars = digest.digest(input.getBytes("UTF-8"));

			for(int i = 0; i < chars.length; i++) {

				String hex = Integer.toHexString(0xff & chars[i]);

				if(hex.length() == 1) result.append('0');

				result.append(hex);

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		//결과반환
		return result.toString();

	}

}
