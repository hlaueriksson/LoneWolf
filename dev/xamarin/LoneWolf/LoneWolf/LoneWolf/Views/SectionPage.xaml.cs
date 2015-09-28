using System;
using LoneWolf.Models;
using LoneWolf.ViewModels;
using Xamarin.Forms;

namespace LoneWolf.Views
{
	public partial class SectionPage : ContentPage
	{
		public SectionPage()
		{
			InitializeComponent();
		}

		private void Browser_OnNavigating(object sender, WebNavigatingEventArgs e)
		{
			Log("Browser_OnNavigating");

			e.Cancel = true;

			var number = GetSectionNumber(e.Url);
			var next = new Random().Next(250).ToString();

			var model = BindingContext as SectionViewModel;

			if (model == null) return;

			model.Section = new Section { Number = number };
			model.Source = new HtmlWebViewSource
			{
				Html =
$@"<html><body>
<h1>{number}</h1>
<p>Your life and your quest end here.</p>
<p>Turn to <a href='hybrid:section/{next}'>{next}</a></p>
</body></html>"
			};
		}

		private string GetSectionNumber(string url)
		{
			return url.Replace("hybrid:section/", string.Empty);
		}

		private void Browser_OnNavigated(object sender, WebNavigatedEventArgs e)
		{
			Log("Browser_OnNavigated");
		}

		private static void Log(string message)
		{
			System.Diagnostics.Debug.WriteLine(message);
		}
	}
}