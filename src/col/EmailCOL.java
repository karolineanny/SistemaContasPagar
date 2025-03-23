package col;

import model.EmailFornecedor;
import java.util.List;
import java.util.regex.Pattern;

public class EmailCOL {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    public static boolean emailsValidos(List<EmailFornecedor> emails) {
        for (EmailFornecedor email : emails) {
            if (!emailValido(email)) {
                return false;
            }
        }
        return true;
    }

    private static boolean emailValido(EmailFornecedor email) {
        return email != null &&
                email.getEmailFornecedor() != null &&
                !email.getEmailFornecedor().trim().isEmpty() &&
                EMAIL_PATTERN.matcher(email.getEmailFornecedor()).matches() &&
                email.getFornecedor() != null &&
                email.getFornecedor().getIdFornecedor() != null &&
                email.getFornecedor().getIdFornecedor() > 0;
    }
}