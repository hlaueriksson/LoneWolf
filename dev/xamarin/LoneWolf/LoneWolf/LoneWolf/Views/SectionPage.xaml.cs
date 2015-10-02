using LoneWolf.Extensions;
using LoneWolf.Models;
using LoneWolf.Models.Book01;
using LoneWolf.ViewModels;
using Xamarin.Forms;

namespace LoneWolf.Views
{
	public partial class SectionPage : ContentPage
	{
		public SectionPage()
		{
			InitializeComponent();

			UpdateModel("1");
		}

		private void Browser_OnNavigating(object sender, WebNavigatingEventArgs e)
		{
			Log("Browser_OnNavigating");

			e.Cancel = true;

			var number = GetSectionNumber(e.Url);

			UpdateModel(number);
		}

		private void Browser_OnNavigated(object sender, WebNavigatedEventArgs e)
		{
			Log("Browser_OnNavigated");
		}

		private string GetSectionNumber(string url)
		{
			return url.Replace("hybrid:section/", string.Empty);
		}

		private void UpdateModel(SectionReference number)
		{
			var model = BindingContext as SectionViewModel;

			if (model == null) return;

			model.Section = GetSection(number);
		}

		private static Section GetSection(SectionReference number)
		{
			var json = DependencyService.Get<ISectionReader>().Read(new SectionReference(number));

			switch (number)
			{
				case "0":
					return json.TypedDeserialize<Section000>();
				default:
					return json.TypedDeserialize<Section>();
			}
		}

		private static void Log(string message)
		{
			System.Diagnostics.Debug.WriteLine(message);
		}
	}
}