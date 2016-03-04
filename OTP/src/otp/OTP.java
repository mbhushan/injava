package otp;

public class OTP {
	public static String generate(String key, String base, int digits,
			String provider) {
		return OTPProviderFactory.getOTPProvider(provider).generate(key, base, digits);
	}
}
