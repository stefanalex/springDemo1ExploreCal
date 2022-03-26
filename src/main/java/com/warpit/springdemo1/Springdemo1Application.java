package com.warpit.springdemo1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.warpit.springdemo1.domain.Difficulty;
import com.warpit.springdemo1.domain.Region;
import com.warpit.springdemo1.service.TourPackageService;
import com.warpit.springdemo1.service.TourService;


import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.PropertyAccessor.FIELD;


@SpringBootApplication
public class Springdemo1Application implements CommandLineRunner{
	
	
	@Value("${ec.importfile}")
	private String importFile;
	
	
	@Value("classpath:${ec.importfile}")
	private Resource resource;
	
	@Autowired
	private TourPackageService tourPackageService;
	
	@Autowired
	private TourService tourService;

	public static void main(String[] args) {
		SpringApplication.run(Springdemo1Application.class, args);
	}

	
	@Override
    public void run(String... args) throws Exception {
        createTourPackages();
        long numOfTourPackages = tourPackageService.total();
       // createTours(importFile);
        createTours(resource);
        long numOfTours = tourService.total();
    }

    /**
     * Initialize all the known tour packages
     */
	private void createTourPackages(){
        tourPackageService.createTourPackage("BC", "Backpack Cal");
        tourPackageService.createTourPackage("CC", "California Calm");
        tourPackageService.createTourPackage("CH", "California Hot springs");
        tourPackageService.createTourPackage("CY", "Cycle California");
        tourPackageService.createTourPackage("DS", "From Desert to Sea");
        tourPackageService.createTourPackage("KC", "Kids California");
        tourPackageService.createTourPackage("NW", "Nature Watch");
        tourPackageService.createTourPackage("SC", "Snowboard Cali");
        tourPackageService.createTourPackage("TC", "Taste of California");
    }

	
	/**
     * Create tour entities from an external file
     */
    private void createTours(Resource fileToImport) throws IOException {
        TourFromFile.read(fileToImport).forEach(importedTour ->
            tourService.createTour(importedTour.getTitle(),
                    importedTour.getDescription(),
                    importedTour.getBlurb(),
                    importedTour.getPrice(),
                    importedTour.getLength(),
                    importedTour.getBullets(),
                    importedTour.getKeywords(),
                    importedTour.getPackageType(),
                    importedTour.getDifficulty(),
                    importedTour.getRegion()));
    }

    /**
     * Helper class to import ExploreCalifornia.json
     */
    private static class TourFromFile {
        //fields
        private String packageType, title, description, blurb, price, length,
                bullets, keywords, difficulty, region;
        //reader
        static List<TourFromFile> read(Resource fileToImport) throws IOException {
        	
        	InputStream fileToImportStream = fileToImport.getInputStream();
            return new ObjectMapper().setVisibility(FIELD, ANY).
                    readValue(fileToImportStream, new TypeReference<List<TourFromFile>>() {});
        }
        
        
        
        
        protected TourFromFile(){}

        String getPackageType() { return packageType; }

        String getTitle() { return title; }

        String getDescription() { return description; }

        String getBlurb() { return blurb; }

        Integer getPrice() { return Integer.parseInt(price); }

        String getLength() { return length; }

        String getBullets() { return bullets; }

        String getKeywords() { return keywords; }

        Difficulty getDifficulty() { return Difficulty.valueOf(difficulty); }

        Region getRegion() { return Region.findByLabel(region); }
    }

}
