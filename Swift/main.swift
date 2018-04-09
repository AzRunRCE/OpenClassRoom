// Fonction permettant de demander à l'utilisateur d'entrer un nombre et de le convertir en entier
func input() -> Int {
    let strData = readLine()
    
    return Int(strData!)!
}

func carre(nombre:Int) -> Int {
    return nombre * nombre
}

// Déclaration des variables utiles pour le TP
var nombre1: Int
var nombre2: Int
var operateur: Int // Comprendra un nombre correspondant au menu (par exemple 1 pour une Addition)
var resultat: Int
var continuer: Int = 0
var compte: Int = 0
// On boucle tant que l'utilisateur n'a pas rentré un nombre compris entre 1 et 5
repeat {
    print("Vous avez realisé \(compte) calculs")
    // On affiche tout d'abord le menu
    print("--- Menu ---")
    print("1. Addition")
    print("2. Soustraction")
    print("3. Multiplication")
    print("4. Division")
    print("5. Modulo")
    print("6. Carre")
    print("")
    
    // On demande à l'utilisateur ce qu'il souhaite
    print("Que voulez-vous ? (de 1 à 6) ")
    operateur = input()
    print("") // Permet de réaliser un saut de ligne
    
    // Pour réaliser l'opération, il est nécessaire d'avoir entré un nombre qui correspond au menu
    if (operateur > 0 && operateur < 7) {
        // L'utilisateur rentre le premier nombre
        print("Entrez le premier nombre : ")
        nombre1 = input()
        // L'utilisateur rentre le deuxième nombre sauf si c'est le carré qu'on demande
        if operateur != 6 {
            print("Entrez le deuxième nombre : ")
            nombre2 = input()
        } else {
            nombre2 = nombre1
        }
      
        
        switch operateur {
        case 1: // Addtion
            resultat = nombre1 + nombre2
            
        case 2: // Soustraction
            resultat = nombre1 - nombre2
            
        case 3: // Multiplication
            resultat = nombre1 * nombre2
            
        case 4: // Division
            resultat = nombre1 / nombre2

        case 5: // Modulo
            resultat = nombre1 % nombre2
            
        case 6: // Carre
            resultat = carre(nombre: nombre1)
            
        default:
            resultat = 0 // On ne devrait pas entrer dans ce cas normalement, mais si jamais, on indique à 0 le résultat.
            print("Une erreur est survenue.")
        }
        
        // Enfin, on affiche le résultat
        print("")
        print("Le résultat de l'opération est : \(resultat)")
        print("")
        compte = compte + 1
        // L'utilisateur rentre le deuxième nombre
        print("Voulez-vous continuer a utilisé la calculatrice ? 1:OUI 0:NON")
        continuer = input()
        
       
    }
} while operateur < 1 || operateur > 6 || continuer == 1
