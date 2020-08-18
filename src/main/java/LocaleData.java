import businessObject.Locale;

public class LocaleData {

    public Locale getMinskLocale() {
        Locale byLocale = new Locale();
        byLocale.setCountry("Belarus");
        byLocale.setLocation("Минск");
        byLocale.setCountryCode("by");
        return byLocale;
    }

    public Locale getMoscowLocale() {
        Locale ruLocale = new Locale();
        ruLocale.setCountry("Russia");
        ruLocale.setLocation("Москва");
        ruLocale.setCountryCode("ru");
        return ruLocale;
    }

    public Locale getNurSultanLocale() {
        Locale kzLocale = new Locale();
        kzLocale.setCountry("Kazakhstan");
        kzLocale.setLocation("Нур-Султан");
        kzLocale.setCountryCode("kz");
        return kzLocale;
    }

    public Locale getYerevanLocale() {
        Locale amLocale = new Locale();
        amLocale.setCountry("Armenia");
        amLocale.setLocation("Ереван");
        amLocale.setCountryCode("am");
        return amLocale;
    }

    public Locale getBishkekLocale() {
        Locale kgLocale = new Locale();
        kgLocale.setCountry("Kyrgyzstan");
        kgLocale.setLocation("Бишкек");
        kgLocale.setCountryCode("kg");
        return kgLocale;
    }

}
