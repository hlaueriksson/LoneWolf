using System;
using System.Diagnostics;

namespace LoneWolf.Models
{
	public class PrologueContext
	{
		public Prologue Prologue { get; set; }

		public ActionChart ActionChart { get; set; }
	}

	[DebuggerDisplay("Prologue {Id}")]
	public class Prologue
	{
		public PrologueReference Id { get; set; }

		public string Body { get; set; }

		public PrologueReference Back { get; set; }
		public PrologueReference Forward { get; set; }
	}

	[DebuggerDisplay("{Value}")]
	public class PrologueReference : IEquatable<PrologueReference>, IEquatable<string>
	{
		public string Value { get; }

		public PrologueReference(string value)
		{
			Value = value;
		}

		public static implicit operator string (PrologueReference value)
		{
			return value.Value;
		}

		public static implicit operator PrologueReference(string value)
		{
			return new PrologueReference(value);
		}

		public bool Equals(PrologueReference other) => other != null && Value == other.Value;

		public bool Equals(string other) => Value == other;

		public static bool operator ==(PrologueReference a, PrologueReference b)
		{
			if (ReferenceEquals(a, b)) return true;
			if (((object)a == null) || ((object)b == null)) return false;

			return a.Value == b.Value;
		}

		public static bool operator !=(PrologueReference a, PrologueReference b) => !(a == b);

		public override int GetHashCode() => Value.GetHashCode();

		public override string ToString() => Value;

		public static readonly PrologueReference Null = "null";
		public static readonly PrologueReference TitlePage = "title";
		public static readonly PrologueReference Dedication = "dedicate";
		public static readonly PrologueReference Acknowledgements = "acknwldg";
		public static readonly PrologueReference TheStorySoFar = "tssf";
		public static readonly PrologueReference TheGameRules = "gamerulz";
		public static readonly PrologueReference KaiDisciplines = "discplnz";
		public static readonly PrologueReference Equipment = "equipmnt";
		public static readonly PrologueReference RulesForCombat = "cmbtrulz";
		public static readonly PrologueReference LevelsOfKaiTraining = "levels";
		public static readonly PrologueReference KaiWisdom = "kaiwisdm";
	}

	public static class PrologueReferenceExtensions
	{
		public static PrologueReference Back(this PrologueReference id)
		{
			if (id == PrologueReference.Dedication) return PrologueReference.TitlePage;
			if (id == PrologueReference.Acknowledgements) return PrologueReference.Dedication;
			if (id == PrologueReference.TheStorySoFar) return PrologueReference.Acknowledgements;
			if (id == PrologueReference.TheGameRules) return PrologueReference.TheStorySoFar;
			if (id == PrologueReference.KaiDisciplines) return PrologueReference.TheGameRules;
			if (id == PrologueReference.Equipment) return PrologueReference.KaiDisciplines;
			if (id == PrologueReference.RulesForCombat) return PrologueReference.Equipment;
			if (id == PrologueReference.LevelsOfKaiTraining) return PrologueReference.RulesForCombat;
			if (id == PrologueReference.KaiWisdom) return PrologueReference.LevelsOfKaiTraining;

			return PrologueReference.Null;
		}

		public static PrologueReference Forward(this PrologueReference id)
		{
			if (id == PrologueReference.TitlePage) return PrologueReference.Dedication;
			if (id == PrologueReference.Dedication) return PrologueReference.Acknowledgements;
			if (id == PrologueReference.Acknowledgements) return PrologueReference.TheStorySoFar;
			if (id == PrologueReference.TheStorySoFar) return PrologueReference.TheGameRules;
			if (id == PrologueReference.TheGameRules) return PrologueReference.KaiDisciplines;
			if (id == PrologueReference.KaiDisciplines) return PrologueReference.Equipment;
			if (id == PrologueReference.Equipment) return PrologueReference.RulesForCombat;
			if (id == PrologueReference.RulesForCombat) return PrologueReference.LevelsOfKaiTraining;
			if (id == PrologueReference.LevelsOfKaiTraining) return PrologueReference.KaiWisdom;

			return PrologueReference.Null;
		}
	}

	public interface IPrologueToggle
	{
		string Execute(string html);
	}

	public class NullPrologueToggle : IPrologueToggle
	{
		public string Execute(string html)
		{
			return html;
		}
	}

	public class TheGameRulesToggle : IPrologueToggle
	{
		private readonly PrologueContext _context;

		public TheGameRulesToggle(PrologueContext context)
		{
			_context = context;
		}

		public string Execute(string html)
		{
			return html
				.Disable("CombatSkill", () => _context.ActionChart.CombatSkill.Value > 0)
				.Disable("Endurance", () => _context.ActionChart.Endurance.Value > 0);
		}
	}
}