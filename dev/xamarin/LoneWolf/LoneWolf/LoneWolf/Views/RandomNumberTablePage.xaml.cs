using LoneWolf.Domain;
using LoneWolf.ViewModels;
using Xamarin.Forms;

namespace LoneWolf.Views
{
	public partial class RandomNumberTablePage : ContentPage
	{
		public const string ResultMessage = "Result";

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

			var result = _randomNumberTable.Next();

			model.Result = result;

			MessagingCenter.Send(this, ResultMessage, result);
		}
	}
}