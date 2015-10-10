using System;
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
			Prologue,
			ActionChart,
			CombatSkill,
			Endurance,
			KaiDiscipline,
			GoldCrowns,
			MapOfSommerlund,
			Equipment
		}

		private PropertiesRepository<ActionChart> ActionChartRepository { get; } = new PropertiesRepository<ActionChart>();

		private RandomNumberResult RandomNumberResult { get; set; } = RandomNumberResult.Null;

		public ProloguePage()
		{
			InitializeComponent();

			UpdateModel(ActionChartRepository.Get());

			UpdateModel(PrologueReference.TitlePage);

			MessagingCenter.Subscribe<RandomNumberTablePage, RandomNumberResult>(this, RandomNumberTablePage.ResultMessage, (sender, arg) =>
			{
				Log(RandomNumberTablePage.ResultMessage + ": " + arg.ToString());

				RandomNumberResult = arg;
			});
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
				case RouteAction.CombatSkill:
					CombatSkill(e);
					break;
				case RouteAction.Endurance:
					Endurance(e);
					break;
				case RouteAction.KaiDiscipline:
					KaiDiscipline(e);
					break;
				case RouteAction.GoldCrowns:
					GoldCrowns(e);
					break;
				case RouteAction.MapOfSommerlund:
					MapOfSommerlund(e);
					break;
				case RouteAction.Equipment:
					Equipment(e);
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

		private void UpdateModel(ActionChart actionChart)
		{
			var model = BindingContext as PrologueViewModel;

			if (model == null) return;

			model.ActionChart = actionChart;
		}

		private void UpdateModel()
		{
			(BindingContext as PrologueViewModel)?.Update();
		}

		private void UpdateModel(PrologueReference id)
		{
			var model = BindingContext as PrologueViewModel;

			if (model == null) return;

			model.Prologue = GetPrologue(id);
		}

		private Prologue GetPrologue(PrologueReference id)
		{
			var body = $@"<h1>{id}</h1><p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>";

			if (id == PrologueReference.TheGameRules)
			{
				body += "<p><a href=\"hybrid:actionchart\">ActionChart</a></p>";
				body += "<p><a href=\"hybrid:combatskill\" id=\"CombatSkill\" class=\"enabled\" onclick=\"disable(this);\">CombatSkill</a></p>";
				body += "<p><a href=\"hybrid:endurance\" id=\"Endurance\" class=\"enabled\" onclick=\"disable(this);\">Endurance</a></p>";
			}

			if (id == PrologueReference.KaiDisciplines)
			{
				foreach (KaiDiscipline discipline in Enum.GetValues(typeof(KaiDiscipline)))
				{
					body += $"<p><a href=\"hybrid:kaidiscipline/{discipline}\" id=\"{discipline}\" class=\"enabled\" onclick=\"toggleKaiDiscipline(this);\">{discipline}</a></p>";
				}
			}

			if (id == PrologueReference.Equipment)
			{
				body += "<p><a href=\"hybrid:goldcrowns\">GoldCrowns</a></p>";
				body += "<p><a href=\"hybrid:mapofsommerlund\">MapOfSommerlund</a></p>";
				body += "<p><a href=\"hybrid:equipment\">Equipment</a></p>";
			}

			return new Prologue { Id = id, Body = body, Back = id.Back(), Forward = id.Forward() };
		}

		private RouteAction GetRouteAction(string url)
		{
			if (url.StartsWith("hybrid:prologue/")) return RouteAction.Prologue;
			if (url == "hybrid:actionchart") return RouteAction.ActionChart;
			if (url == "hybrid:combatskill") return RouteAction.CombatSkill;
			if (url == "hybrid:endurance") return RouteAction.Endurance;
			if (url.StartsWith("hybrid:kaidiscipline/")) return RouteAction.KaiDiscipline;
			if (url == "hybrid:goldcrowns") return RouteAction.GoldCrowns;
			if (url == "hybrid:mapofsommerlund") return RouteAction.MapOfSommerlund;
			if (url == "hybrid:equipment") return RouteAction.Equipment;

			return RouteAction.None;
		}

		private void Prologue(WebNavigatingEventArgs e)
		{
			var id = GetPrologueReference(e.Url);

			UpdateModel(id);
		}

		private async void CombatSkill(WebNavigatingEventArgs e)
		{
			Log("CombatSkill");

			await Navigation.PushAsync(new RandomNumberTablePage());

			if (RandomNumberResult == RandomNumberResult.Null) return;

			ActionChartRepository.Update(model => model.CombatSkill.Set(RandomNumberResult + 10));
			await ActionChartRepository.SaveAsync();

			Log(RandomNumberResult);
		}

		private async void Endurance(WebNavigatingEventArgs e)
		{
			Log("Endurance");

			await Navigation.PushAsync(new RandomNumberTablePage());

			if (RandomNumberResult == RandomNumberResult.Null) return;

			ActionChartRepository.Update(model => model.Endurance.Set(RandomNumberResult + 20));
			await ActionChartRepository.SaveAsync();

			Log(RandomNumberResult);
		}

		private async void KaiDiscipline(WebNavigatingEventArgs e)
		{
			Log("KaiDiscipline");

			var discipline = GetKaiDiscipline(e.Url);

			if (discipline == Models.KaiDiscipline.None) return;

			var hasKaiDiscipline = ActionChartRepository.Get().Has(discipline);

			if (hasKaiDiscipline)
			{
				ActionChartRepository.Update(model => model.KaiDisciplines.Remove(discipline));

				await ActionChartRepository.SaveAsync();

				return;
			}

			if (ActionChartRepository.Get().KaiDisciplines.Count >= 5)
			{
				await DisplayAlert("Rules", "You can only choose five Kai Disciplines. Click on a selected discipline to unchoose it.", "OK");

				return;
			}

			ActionChartRepository.Update(model => model.KaiDisciplines.Add(discipline));

			await ActionChartRepository.SaveAsync();

			Log(discipline);

			if (discipline != Models.KaiDiscipline.Weaponskill) return;
			if (ActionChartRepository.Get().WeaponSkill != WeaponSkill.None) return; // NOTE: do not reset WeaponSkill

			await Navigation.PushAsync(new RandomNumberTablePage());

			if (RandomNumberResult == RandomNumberResult.Null) return;

			var skill = GetWeaponSkill(RandomNumberResult);

			ActionChartRepository.Update(model => model.WeaponSkill = skill);
			await ActionChartRepository.SaveAsync();

			Log(skill);
		}

		private WeaponSkill GetWeaponSkill(RandomNumberResult result)
		{
			switch (result)
			{
				case 0: return WeaponSkill.Dagger;
				case 1: return WeaponSkill.Spear;
				case 2: return WeaponSkill.Mace;
				case 3: return WeaponSkill.ShortSword;
				case 4: return WeaponSkill.Warhammer;
				case 5: return WeaponSkill.Sword;
				case 6: return WeaponSkill.Axe;
				case 7: return WeaponSkill.Sword;
				case 8: return WeaponSkill.Quarterstaff;
				case 9: return WeaponSkill.Broadsword;
				default: throw new ArgumentOutOfRangeException();
			}
		}

		private async void GoldCrowns(WebNavigatingEventArgs e)
		{
			Log("GoldCrowns");

			await Navigation.PushAsync(new RandomNumberTablePage());

			if (RandomNumberResult != RandomNumberResult.Null) Log($"BeltPouch.Set({RandomNumberResult})");
		}

		private void MapOfSommerlund(WebNavigatingEventArgs e)
		{
			Log("MapOfSommerlund");
		}

		private async void Equipment(WebNavigatingEventArgs e)
		{
			Log("Equipment");

			await Navigation.PushAsync(new RandomNumberTablePage());

			if (RandomNumberResult == RandomNumberResult.Null) return;

			var equipment = GetEquipment(RandomNumberResult);

			Log($"Equipment.Set({equipment})");
		}

		private string GetEquipment(RandomNumberResult result)
		{
			switch (result)
			{
				case 1: return "Sword";
				case 2: return "Helmet";
				case 3: return "Two Meals";
				case 4: return "Chainmail Waistcoat";
				case 5: return "Mace";
				case 6: return "Healing Potion";
				case 7: return "Quarterstaff";
				case 8: return "Spear";
				case 9: return "12 GoldCrowns";
				case 0: return "Broadsword";
				default: throw new ArgumentOutOfRangeException();
			}
		}

		private PrologueReference GetPrologueReference(string url)
		{
			return url.Replace("hybrid:prologue/", string.Empty);
		}

		private KaiDiscipline GetKaiDiscipline(string url)
		{
			var value = url.Replace("hybrid:kaidiscipline/", string.Empty);

			return value.GetKaiDiscipline();
		}

		private void Log(object message)
		{
			Log(message.ToString());
		}

		private static void Log(string message)
		{
			System.Diagnostics.Debug.WriteLine(message);
		}
	}
}