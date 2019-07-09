package test.pratice;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddress {
	public int numUniqueEmails(String[] emails) {
		Set<String> emailSet = new HashSet<>();
		for (String email : emails) {
			String[] parts = email.split("@");
			String[] pre = parts[0].split("\\+");
			String emailStr = pre[0].replace(".", "") + "@" + parts[1];
			emailSet.add(emailStr);		
		}
		return emailSet.size();
	}
}
