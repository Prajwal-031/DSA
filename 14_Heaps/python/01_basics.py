"""
Heaps - Interview prep (Python)
================================
Starter layout: add real functions/classes for Heaps as you study.
"""

from __future__ import annotations


class HeapsBasics:
    """Organize Heaps notes and sample APIs here."""

    TOPIC = "Heaps"

    @staticmethod
    def describe() -> str:
        return (
            "Topic: " + HeapsBasics.TOPIC + ". Add real structures and algorithms for interviews."
        )

    @staticmethod
    def checklist() -> list[str]:
        return [
            "Definition and when to use Heaps",
            "Core operations and complexities",
            "Two easy + two medium problems solved",
            "One hard attempted with analysis",
        ]


def main() -> None:
    print(HeapsBasics.describe())
    for item in HeapsBasics.checklist():
        print(" -", item)


if __name__ == "__main__":
    main()