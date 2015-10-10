using System;
using System.IO;
using LoneWolf.Models;
using Machine.Specifications;

namespace LoneWolf.Test.Views
{
	public class Given_PrologueView
	{
		[Subject(typeof(PrologueView))]
		public class GenerateString
		{
			static PrologueView subject;

			Establish context = () =>
			{
				subject = new PrologueView();
			};

			It should_render_valid_model = () =>
			{
				subject.Model = new Prologue { Id = PrologueReference.TitlePage, Back = PrologueReference.Null, Forward = PrologueReference.Dedication };
				var result = subject.GenerateString();

				result.ShouldNotBeEmpty();
				result.ShouldContain("id=\"back\" class=\"disabled\"");
				result.ShouldContain("id=\"forward\" class=\"enabled\"");
			};
		}

		[Subject(typeof(PrologueView))]
		[Ignore("Run manually")]
		public class Generate
		{
			static PrologueView subject;

			Establish context = () =>
			{
				subject = new PrologueView();
			};

			It write_files_to_disk = () =>
			{
				var body = "";

				foreach (KaiDiscipline discipline in Enum.GetValues(typeof(KaiDiscipline)))
				{
					body += $"<p><a href=\"hybrid:kaidiscipline/{discipline}\" id=\"{discipline}\" class=\"enabled\" onclick=\"toggleKaiDiscipline(this);\">{discipline}</a></p>";
				}

				subject.Model = new Prologue { Id = PrologueReference.TitlePage, Body = body, Back = PrologueReference.Null, Forward = PrologueReference.Dedication };
				var result = subject.GenerateString();

				var path = GetCurrentDirectory() + @"\..\..\Views\Html\";
				var name = "PrologueView.html";

				File.WriteAllText(path + name, System.Net.WebUtility.HtmlDecode(result));
			};

			private static string GetCurrentDirectory()
			{
				return Path.GetDirectoryName(System.Reflection.Assembly.GetExecutingAssembly().GetName().CodeBase).Replace(@"file:\", string.Empty);
			}
		}
	}
}