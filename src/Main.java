public class Main {
    public static void main(String[] args) {
        TaxCalc calculator = new TaxCalc();

        calculator.setVehicleDetails("Estate", 5000000, 7, 1600, 1800, 6, true);
        calculator.calculateEstateTaxes();


        calculator.setVehicleDetails("SUV", 7000000, 6, 1800, 2500, 3, true);
        calculator.calculateSuvTaxes();

        calculator.setVehicleDetails("Ambulance", 3000000, 3, 1400, 1200, 8, false);
        calculator.calculateAmbulanceTaxes();

        calculator.setVehicleDetails("Sedan", 340000, 4, 1400, 1340, 6, true);
        calculator.calculateSedanTaxes();

        calculator.setVehicleDetails("Trailer", 300000, 8, 2400, 1940, 7, true);
        calculator.calculateTrailerTaxes();

        calculator.calculateStandardVehicleTaxes();

        calculator.calculateTransportationAndBondFees(12);
    }
}
