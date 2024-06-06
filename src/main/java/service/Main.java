package service;

import model.Assure;

public class Main {

    public static void main(String[] args) {
        AssureService assureService = new AssureService();

        // Test avec un numéro de sécurité sociale valide
        String numeroSecSocValide = "H1234567";
        Assure assureValide = assureService.getAssureDetails(numeroSecSocValide);
        if (assureValide != null) {
            System.out.println("Détails de l'assuré avec numéro de sécurité sociale valide :");
            System.out.println("Nom: " + assureValide.getNom());
            System.out.println("Prénom: " + assureValide.getPrenom());
            System.out.println("Numéro de Sécurité Sociale: " + assureValide.getNumeroSecSoc());
            System.out.println("Adresse: " + assureValide.getAdresse());
            System.out.println("Date de Naissance: " + assureValide.getDateNaissance());
        } else {
            System.out.println("Aucun détail trouvé pour le numéro de sécurité sociale valide.");
        }

        // Test avec un numéro de sécurité sociale invalide
        String numeroSecSocInvalide = "0000000000000";
        Assure assureInvalide = assureService.getAssureDetails(numeroSecSocInvalide);
        if (assureInvalide != null) {
            System.out.println("Détails de l'assuré avec numéro de sécurité sociale invalide :");
            System.out.println("Nom: " + assureInvalide.getNom());
            System.out.println("Prénom: " + assureInvalide.getPrenom());
            System.out.println("Numéro de Sécurité Sociale: " + assureInvalide.getNumeroSecSoc());
            System.out.println("Adresse: " + assureInvalide.getAdresse());
            System.out.println("Date de Naissance: " + assureInvalide.getDateNaissance());
        } else {
            System.out.println("Aucun détail trouvé pour le numéro de sécurité sociale invalide.");
        }
    }
}
