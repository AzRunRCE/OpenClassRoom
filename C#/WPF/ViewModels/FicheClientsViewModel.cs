using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Runtime.CompilerServices;
using System.Windows.Input;
using WPFBinding.Models;

namespace WPFBinding.ViewModels
{
    public class FicheClientsViewModel : INotifyPropertyChanged
    {
        public event PropertyChangedEventHandler PropertyChanged;

        public void NotifyPropertyChanged([CallerMemberName] string str = "")
        {
            if (PropertyChanged != null)
            {
                PropertyChanged(this, new PropertyChangedEventArgs(str));
            }
        }

        private ObservableCollection<Client> fiches;

        public ObservableCollection<Client> Fiches
        {
            get { return fiches; }

            set
            {
                if (value != fiches)
                {
                    fiches = value;
                    NotifyPropertyChanged();
                }
            }
        }

        private Client ficheSelectionnee;

        public Client FicheSelectionnee
        {
            get { return ficheSelectionnee; }

            set
            {
                if (value != ficheSelectionnee)
                {
                    ficheSelectionnee = value;
                    NotifyPropertyChanged();
                }
            }
        }

        /// <summary>
        /// Constructeur FicheClientsViewModel. Crée un premier client.
        /// </summary>
        public FicheClientsViewModel()
        {
            Fiches = new ObservableCollection<Client>();

            FicheSelectionnee = new Client()
            {
                Lastname = "Dupont",
                Firstname = "Pierre",
                Age = 32,
                Sex = "M",
                Street = "2 Rue des colombes",
                City = "Paris",
                Country = "France",
                Phone = "3615",
                PostalCode = "75000",
                Job = "Dev"
            };

            Fiches.Add(FicheSelectionnee);
        }

        /// <summary>
        /// Assigne toute les proprietées d'un client recu en paramèttre a vide.
        /// </summary>
        private ICommand remiseAZeroDeLaFicheSelectionnee = new RelayCommand<Client>((client) =>
        {
            client.Age = 0;
            client.Lastname = "";
            client.Firstname = "";
            client.Sex = "";
            client.City = "";
            client.Country = "";
            client.Phone = "";
            client.Street = "";
            client.PostalCode = "";
            client.Job = "";
        });

        public ICommand RemiseAZeroDeLaFicheSelectionnee
        {
            get { return remiseAZeroDeLaFicheSelectionnee; }
        }

        /// <summary>
        /// Ajoute un nouveau Client a la liste des clients
        /// </summary>
        private ICommand ajoutDUneFicheClient;

        public ICommand AjoutDUneFicheClient
        {
            get
            {
                if (ajoutDUneFicheClient == null)
                {
                    ajoutDUneFicheClient = new RelayCommand<object>((obj) => Fiches.Add(new Client()));
                }
                return ajoutDUneFicheClient;
            }
        }


        /// <summary>
        /// Supprime l'objet Client recu en paramèttre de la liste des clients.
        /// </summary>
        private ICommand retraitDUneFicheClient;

        public ICommand RetraitDUneFicheClient
        {
            get
            {
                if (retraitDUneFicheClient == null)
                {
                    retraitDUneFicheClient = new RelayCommand<Client>((client) => Fiches.Remove(client));
                }
                return retraitDUneFicheClient;
            }
        }

        /// <summary>
        /// Change la sélection courante. Assigne la variable FicheSelectionnee à l'objet Client recu en paraméttre
        /// </summary>
        private ICommand editionDUneFicheClient;

        public ICommand EditionDUneFicheClient
        {
            get
            {
                if (editionDUneFicheClient == null)
                {
                    editionDUneFicheClient = new RelayCommand<Client>((client) => FicheSelectionnee = client);
                }
                return editionDUneFicheClient;
            }
        }
    }
}