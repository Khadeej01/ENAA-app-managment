import java.util.ArrayList;
import java.util.Scanner;

public class Apprenant extends Personne{
    private int id;
private double notes;
Classe classe;
Application application = new Application();
    public Apprenant(int id, String nom, String prenom, String email, double notes, Classe classes) {
        super(id, nom, prenom, email);
        this.notes = notes;
        this.classe = classes;
    }
   public Apprenant(){
       super();

   }



    public double getNotes() {
        return notes;
    }

    public void setNotes(double notes) {
        this.notes = notes;
    }

    public Object getClasse() {
        return classe;
    }

    public String setClasse(Classe classe) {
        this.classe = classe;
        return null;
    }

    @Override
    public String toString() {
        return "Apprenant{" +
                "classe=" + classe +
                ", notes=" + notes +
                "} " + super.toString();
    }
    public void gestionApprenants() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1-Ajouter votre apprenant:");
        System.out.println("2-Modifier votre apprenant:");
        System.out.println("3-Supprimer votre apprenant:");
        System.out.println("4-Afficher votre apprenant:");

        int choice;
        System.out.println("Veullez saisir le choix:");
        choice = sc.nextInt();
        Apprenant apprenant = new Apprenant();
        switch (choice) {
            case 1:

                apprenant.AjouterApprenant();
                break;
                case 2:

                    apprenant.AfficherApprenant();
                    break;
            case 3:
                apprenant.ModifierApprenant();
                break;
                case 4:
                    apprenant.SupprimerApprenant();
                    break;
                    default:
                        System.out.println("Choix invalide !!");
        }
    }

    // Ajout d'Apprenant
    public  void AjouterApprenant() {
        Scanner sc = new Scanner(System.in);


        System.out.println("Veuillez saisir le nom :");
        String nom = sc.nextLine();
        System.out.println("Veuillez saisir le prenom :");
        String prenom = sc.nextLine();
        System.out.println("Veuillez saisir email (@gmail.com) :");
        String email = sc.nextLine();
        System.out.println("Veuillez saisir les notes :");
        double notes = sc.nextDouble();
        sc.nextLine();
        System.out.println("Veuillez saisir classe :");
        String classenom = sc.nextLine();
        Apprenant ap=new Apprenant();
        Classe c = new Classe();
        Classe classe=c.rechercheClasse(classenom);
        if (classe == null) {
            System.out.println("Classe n'existe pas dans la classe " + classenom);
            return;
        }


        ap = new Apprenant(id,nom,prenom,email,notes,classe);

        application.apprenants.add(ap);
        System.out.println("Apprenant ajouter avec succes");
        id = application.apprenants.size()+1;
            }
            // Modifier Apprenant

                public  void ModifierApprenant() {
                    Scanner sc = new Scanner(System.in);

                    System.out.print("Entrez l'ID de l'apprenant à modifier : ");
                    int idRecherche = sc.nextInt();
                    sc.nextLine();


                    Apprenant apprenant = rechercherApprenantParID(idRecherche);
                    if (apprenant == null) {
                        System.out.println("Apprenant introuvable.");
                        return;
                    }


                    System.out.print("Nouveau nom : ");
                    String nom = sc.nextLine();
                    apprenant.setNom(nom);
                    System.out.print("Nouveau prénom : ");
                    String prenom = sc.nextLine();
                    apprenant.setPrenom(prenom);
                    System.out.print("Nouvel email : ");
                    String email = sc.nextLine();
                    apprenant.setEmail(email);
                    System.out.print("Nouvelle notes : ");
                    double notes = sc.nextDouble();
                    apprenant.setNotes(notes);
                    sc.nextLine();
                    System.out.print("Nouvelle classe : ");
                    String classenom = sc.nextLine();
                    Apprenant ap=new Apprenant();
                    Classe classe=new Classe(classenom,null);
                   ap.setNom(ap.setClasse(classe));
                    ap = new Apprenant(id,nom,prenom,email,notes,classe);


                    System.out.println("Apprenant modifié avec succès !");
                }


    public  Apprenant rechercherApprenantParID(int id) {
        for (Apprenant a : application.apprenants) {
            if (a.getId() == id) return a;
        }
        return null;
    }
    //Supression d'appronant
    private  void SupprimerApprenant() {
        Scanner sc = new Scanner(System.in);

        System.out.print("ID de l'apprenant à supprimer: ");
        int id = sc.nextInt();
       sc.nextLine();


        application.apprenants.removeIf(apprenant -> apprenant.getId() == id);
        System.out.println("Apprenant supprimé !");
    }

    // Afficher
            public  void AfficherApprenant() {
                if (application.apprenants.isEmpty()) {
                    System.out.println("Aucun apprenant enregistré.");
                } else {
                    for (Apprenant apprenant : application.apprenants) {
                        System.out.println(apprenant.toString());
                    }
                }
            }


        }

