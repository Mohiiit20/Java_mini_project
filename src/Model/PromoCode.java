package Model;
// an interface containing some operations related to airline

public interface PromoCode {
    abstract String generatePromoCode();
    abstract boolean isPromoCodeValid(String promoCode);

}

