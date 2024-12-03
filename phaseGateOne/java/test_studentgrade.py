from unittest import TestCase
from studentgrades import *

class TestStudentGrade(TestCase):
    def test_that_collect_scores_function_exists(self):
        collect_scores(1,1)
        
    def test_that_everage_returns_correct_result(self):
        actual = get_average_score_of([1,2,3])
        expected = 2.0
        self.assertEquals(actual, expected)
