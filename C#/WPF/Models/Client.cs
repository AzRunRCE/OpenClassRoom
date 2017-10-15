using System.ComponentModel;

namespace WPFBinding.Models
{
    public class Client : INotifyPropertyChanged
    {
        private string firstName;

        private string lastName;

        private string sex;

        private int age;

        private string phone;

        private string street;

        private string postalCode;

        private string country;

        private string city;


        private string job;


        public event PropertyChangedEventHandler PropertyChanged;

        public string Firstname
        {
            get { return firstName; }

            set
            {
                if (value != firstName)
                {
                    firstName = value;
                    if (PropertyChanged != null)
                    {
                        PropertyChanged(this, new PropertyChangedEventArgs("Firstname"));
                    }
                }
            }
        }

        public string Lastname
        {
            get { return lastName; }

            set
            {
                if (value != lastName)
                {
                    lastName = value;
                    if (PropertyChanged != null)
                    {
                        PropertyChanged(this, new PropertyChangedEventArgs("Lastname"));
                    }
                }
            }
        }

        public string Sex
        {
            get { return sex; }

            set
            {
                if (value != sex)
                {
                    sex = value;
                    if (PropertyChanged != null)
                    {
                        PropertyChanged(this, new PropertyChangedEventArgs("Sex"));
                    }
                }
            }
        }

        public int Age
        {
            get { return age; }

            set
            {
                if (value != age)
                {
                    age = value;
                    if (PropertyChanged != null)
                    {
                        PropertyChanged(this, new PropertyChangedEventArgs("Age"));
                    }
                }
            }
        }

        public string Street
        {
            get { return street; }

            set
            {
                if (value != street)
                {
                    street = value;
                    if (PropertyChanged != null)
                    {
                        PropertyChanged(this, new PropertyChangedEventArgs("Street"));
                    }
                }
            }
        }

        public string PostalCode
        {
            get { return postalCode; }

            set
            {
                if (value != postalCode)
                {
                    postalCode = value;
                    if (PropertyChanged != null)
                    {
                        PropertyChanged(this, new PropertyChangedEventArgs("PostalCode"));
                    }
                }
            }
        }

        public string Country
        {
            get { return country; }

            set
            {
                if (value != country)
                {
                    country = value;
                    if (PropertyChanged != null)
                    {
                        PropertyChanged(this, new PropertyChangedEventArgs("Country"));
                    }
                }
            }
        }

        public string City
        {
            get { return city; }

            set
            {
                if (value != city)
                {
                    city = value;
                    if (PropertyChanged != null)
                    {
                        PropertyChanged(this, new PropertyChangedEventArgs("City"));
                    }
                }
            }
        }

        public string Job
        {
            get { return job; }

            set
            {
                if (value != job)
                {
                    job = value;
                    if (PropertyChanged != null)
                    {
                        PropertyChanged(this, new PropertyChangedEventArgs("Job"));
                    }
                }
            }
        }

        public string Phone
        {
            get { return phone; }

            set
            {
                if (value != phone)
                {
                    phone = value;
                    if (PropertyChanged != null)
                    {
                        PropertyChanged(this, new PropertyChangedEventArgs("Phone"));
                    }
                }
            }
        }
    }
}