using System;
using System.Collections.Generic;

namespace LoneWolf.Models
{
	public class ActionChart
	{
		public CombatSkill CombatSkill { get; set; } = new CombatSkill();
		public Endurance Endurance { get; set; } = new Endurance();

		public ISet<KaiDiscipline> KaiDisciplines { get; set; } = new SortedSet<KaiDiscipline>();
		public WeaponSkill WeaponSkill { get; set; } = WeaponSkill.None;

		public BeltPouch BeltPouch { get; set; } = new BeltPouch();

		public bool Has(KaiDiscipline discipline)
		{
			return KaiDisciplines.Contains(discipline);
		}
	}

	public class CombatSkill
	{
		public int Value { get; set; }

		public void Set(int value)
		{
			Value = value;
		}
	}

	public class Endurance
	{
		public int Value { get; set; }
		public int Max { get; set; }

		public void Set(int value)
		{
			Max = Value = value;
		}

		public void Increment(int delta)
		{
			Value += delta;

			if (Value > Max) Value = Max;
		}

		public void Decrement(int delta)
		{
			Value -= delta;

			if (Value < 0) Value = 0;
		}
	}

	public enum KaiDiscipline
	{
		None,
		Camouflage,
		Hunting,
		SixthSense,
		Tracking,
		Healing,
		Weaponskill,
		Mindshield,
		Mindblast,
		AnimalKinship,
		MindOverMatter
	}

	public enum WeaponSkill
	{
		None,
		Dagger,
		Spear,
		Mace,
		ShortSword,
		Warhammer,
		Sword,
		Axe,
		Quarterstaff,
		Broadsword
	}

	public class BeltPouch
	{
		public int Value { get; set; }

		public void Set(int value)
		{
			Value = value;

			if (Value < 0) Value = 0;
			if (Value > 50) Value = 50;
		}
	}

	public static class KaiDisciplineExtensions
	{
		public static KaiDiscipline GetKaiDiscipline(this string value)
		{
			return value.As<KaiDiscipline>();
		}

		private static T As<T>(this string value) where T : struct
		{
			try
			{
				return (T)Enum.Parse(typeof(T), value);
			}
			catch (Exception ex)
			{
				var type = typeof(T).Name;

				Log($"\"{value}\".As<{type}>() failed: {ex.Message}");
			}

			return default(T);
		}

		private static void Log(string message)
		{
			System.Diagnostics.Debug.WriteLine(message);
		}
	}
}