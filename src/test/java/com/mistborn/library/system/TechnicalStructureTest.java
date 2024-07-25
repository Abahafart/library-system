package com.mistborn.library.system;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.core.importer.ImportOption.DoNotIncludeTests;
import com.tngtech.archunit.core.importer.Location;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.Architectures;

/**
 * class evaluate layer declared in test
 */
@AnalyzeClasses(
    packages = {"com.mistborn.library.system"},
    importOptions = {
        DoNotIncludeTests.class, DoNotIncludeGenerated.class
    })
public class TechnicalStructureTest {

  @ArchTest
  static final ArchRule testArchitectureLayer =
      Architectures.layeredArchitecture()
          .consideringAllDependencies()
          .layer("InputPort")
          .definedBy("..infraestructure.input..")
          .layer("OutputPort")
          .definedBy("..infraestructure.output..")
          .layer("Configuration")
          .definedBy("..infraestructure.config..")
          .layer("ApplicationInput")
          .definedBy("..application.ports.input..")
          .layer("ApplicationOutput")
          .definedBy("..application.ports.output..")
          .layer("UseCases")
          .definedBy("..application.usecases..")
          .layer("Domain")
          .definedBy("..domain..")
          .layer("Mapper")
          .definedBy("..infraestructure.mappers..")
          .layer("Repository")
          .definedBy("..infraestructure.output.*.repository..")
          .whereLayer("Domain")
          .mayOnlyBeAccessedByLayers(
              "InputPort",
              "OutputPort",
              "Configuration",
              "ApplicationInput",
              "ApplicationOutput",
              "UseCases",
              "Domain",
              "Mapper",
              "Repository")
          .whereLayer("InputPort")
          .mayNotBeAccessedByAnyLayer()
          .whereLayer("ApplicationOutput")
          .mayOnlyBeAccessedByLayers("ApplicationInput", "OutputPort")
          .whereLayer("ApplicationInput")
          .mayOnlyBeAccessedByLayers("InputPort")
          .whereLayer("UseCases")
          .mayOnlyBeAccessedByLayers("InputPort", "ApplicationInput")
          .whereLayer("Repository")
          .mayOnlyBeAccessedByLayers("OutputPort")
          .whereLayer("Mapper")
          .mayOnlyBeAccessedByLayers("InputPort", "OutputPort")
          .whereLayer("Configuration")
          .mayOnlyBeAccessedByLayers("Mapper");
}

/**
 * do not include classes that are auto generated or exclude some class or specific package
 */
class DoNotIncludeGenerated implements ImportOption {
  @Override
  public boolean includes(Location location) {
    return !location.contains("build/generated") && !location.contains("__");
  }
}
