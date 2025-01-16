from unittest import TestCase
from studentgrades import *

class TestStudentGrade(TestCase):
    def test_that_collect_scores_function_exists(self):
        displayOverallAnalysis([], [], [])
        
    def test_that_get_valid_score_returns_correct_result(self):
        actual = getValidScore(0)
        expected = 30
        self.assertEquals(actual, expected)
