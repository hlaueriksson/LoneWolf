using LoneWolf.Domain;
using LoneWolf.ViewModels;
using Xamarin.Forms;

namespace LoneWolf.Views
{
	public partial class RandomNumberTablePage : ContentPage
	{
		private readonly RandomNumberTable _randomNumberTable;

		public RandomNumberTablePage()
		{
			InitializeComponent();

			_randomNumberTable = new RandomNumberTable(new RandomFacade());

			UpdateModel();
		}

		private void UpdateModel()
		{
			var model = BindingContext as RandomNumberTableViewModel;

			if (model == null) return;

			model.Result = _randomNumberTable.Next();
		}
	}
}