package sistemas.escuelaing.edu.co;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {

        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("sistemas.escuelaing.edu.co");

        noClasses()
            .that()
                .resideInAnyPackage("sistemas.escuelaing.edu.co.service..")
            .or()
                .resideInAnyPackage("sistemas.escuelaing.edu.co.repository..")
            .should().dependOnClassesThat()
                .resideInAnyPackage("..sistemas.escuelaing.edu.co.web..")
        .because("Services and repositories should not depend on web layer")
        .check(importedClasses);
    }
}
