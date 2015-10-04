using LoneWolf.Models;
using LoneWolf.ViewModels;
using Xamarin.Forms;

namespace LoneWolf.Views
{
	public partial class ProloguePage : ContentPage
	{
		private enum RouteAction
		{
			None,
			Prologue
		}

		public ProloguePage()
		{
			InitializeComponent();

			UpdateModel(PrologueReference.TitlePage);
		}

		private void Browser_OnNavigating(object sender, WebNavigatingEventArgs e)
		{
			Log("Browser_OnNavigating");

			e.Cancel = true;

			var route = GetRouteAction(e.Url);

			switch (route)
			{
				case RouteAction.Prologue:
					Prologue(e);
					break;
				default:
					e.Cancel = false; // FIX: iOS
					break;
			}
		}

		private void Browser_OnNavigated(object sender, WebNavigatedEventArgs e)
		{
			Log("Browser_OnNavigated");
		}

		private void UpdateModel(PrologueReference id)
		{
			var model = BindingContext as PrologueViewModel;

			if (model == null) return;

			model.Prologue = GetPrologue(id);
		}

		private Prologue GetPrologue(PrologueReference id)
		{
			return new Prologue { Id = id, Body = id.ToString(), Back = id.Back(), Forward = id.Forward() };
		}

		private RouteAction GetRouteAction(string url)
		{
			if (url.StartsWith("hybrid:prologue/")) return RouteAction.Prologue;

			return RouteAction.None;
		}

		private void Prologue(WebNavigatingEventArgs e)
		{
			var id = GetPrologueReference(e.Url);

			UpdateModel(id);
		}

		private PrologueReference GetPrologueReference(string url)
		{
			return url.Replace("hybrid:prologue/", string.Empty);
		}

		private static void Log(string message)
		{
			System.Diagnostics.Debug.WriteLine(message);
		}
	}
}