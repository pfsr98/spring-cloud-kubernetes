package pe.edu.unmsm.springcloudkubernetes.courseservice.util;

public class Constants {
    private Constants() {
        throw new IllegalStateException(Constants.UTILITY_CLASS);
    }

    public static final String COURSE_NOT_FOUND = "Curso no encontrado con {0}: {1}";
    public static final String DUPLICATE_COURSE = "Ya existe un curso con {0}: {1}";
    public static final String DATE_FORMAT = "dd-MM-yyyy";
    public static final String DATE_TIME_FORMAT = "dd-MM-yyyy HH:mm:ss";
    public static final String UTILITY_CLASS = "Clase de utilidad";
}
