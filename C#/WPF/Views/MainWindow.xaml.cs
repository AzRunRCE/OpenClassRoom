using System.Windows;

namespace WPFBinding.Views
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private readonly double _rightColumnWidth;
        private readonly double _rightColumnMinWidth;
        private bool _rightColumnHidden;


        private readonly double _rightRowHeight;
        private readonly double _rightRowMinHeight;
        private bool _rightRowHidden;

        public MainWindow()
        {
            InitializeComponent();
            //Sauvgarde en mémoire la configuration par défaut.
            _rightColumnWidth = RightColumn.Width.Value;
            _rightColumnMinWidth = RightColumn.MinWidth;

            _rightRowHeight = RightRow.Height.Value;
            _rightRowMinHeight = RightRow.MinHeight;
        }

        private void ToggleButton_Click(object sender, RoutedEventArgs e)
        {
            if (_rightColumnHidden)
            {
                // Restaure la longeur.
                RightColumn.MinWidth = _rightColumnMinWidth;
                RightColumn.Width = new GridLength(_rightColumnWidth, GridUnitType.Star);
            }
            else
            {
                //Défini la nouvelle longeur (0)
                RightColumn.MinWidth = 0;
                RightColumn.Width = new GridLength(0);
            }
            //Met a jour l'état boolean
            _rightColumnHidden = !_rightColumnHidden;
        }

        private void ToggleButton_Down_Click(object sender, RoutedEventArgs e)
        {
            if (_rightRowHidden)
            {
                // Restaure la configuration par défaut.
                RightRow.MinHeight = _rightRowMinHeight;
                RightRow.Height = new GridLength(_rightRowHeight, GridUnitType.Star);
            }
            else
            {
                //Défini la nouvelle hauteur (0)
                RightRow.MinHeight = 0;
                RightRow.Height = new GridLength(0);
            }
            //Met a jour l'état boolean
            _rightRowHidden = !_rightRowHidden;
        }
    }
}