from datetime import date, timedelta


class MenstrualCalculator:
    def __init__(self, flow_start_date: date, flow_end_date: date):
        self.flow_start_date = flow_start_date
        self.flow_end_date = flow_end_date
        self.cycle_length = 28
    
    def set_cycle_length(self, cycle_length: int):
        self.cycle_length = cycle_length
    
    def calculate_flow_duration(self) -> int:
        return (self.flow_end_date - self.flow_start_date).days + 1
    
    def calculate_next_period_date(self):
        return self.flow_start_date + timedelta(days=self.cycle_length)
    
    def calculate_ovulation_date(self):
        return self.calculate_next_period_date() - timedelta(days=14)
    
    def calculate_fertile_window(self):
        fertile_window = []
        ovulation_date = self.calculate_ovulation_date()
        
        
        for i in range(3, -1, -1):
            fertile_window.append(ovulation_date - timedelta(days=i))
        
        
        fertile_window.append(ovulation_date + timedelta(days=1))
        
        return fertile_window
    
    def calculate_safe_period(self) -> :
        safe_period = []
        fertile_start = self.calculate_ovulation_date() - timedelta(days=5)
        fertile_end = self.calculate_ovulation_date() + timedelta(days=1)
        
        current_date = self.flow_end_date + timedelta(days=1)
        while current_date < fertile_start:
            safe_period.append(current_date)
            current_date += timedelta(days=1)
        

        current_date = fertile_end + timedelta(days=2)
        next_period = self.calculate_next_period_date() - timedelta(days=3)
        while current_date < next_period:
            safe_period.append(current_date)
            current_date += timedelta(days=1)
        
        return safe_period
    
    def calculate_pre_menstrual_syndrome_days(self)cahr:
        pms_days = []
        next_period = self.calculate_next_period_date()
        
        for i in range(7, 0, -1):
            pms_days.append(next_period - timedelta(days=i))
        
        return pms_days
    
    def get_fertility_status(self, check_date: date) -> str:

        if (check_date == self.flow_start_date or 
            (check_date > self.flow_start_date and check_date < self.flow_end_date + timedelta(days=1))):
            return "Menstrual Flow"
        

        if check_date in self.calculate_fertile_window():
            if check_date == self.calculate_ovulation_date():
                return "Ovulation Day - Highest Fertility"
            return "Fertile Window - High Fertility"
        

        if check_date in self.calculate_safe_period():
            return "Safe Period - Low Fertility"
        

        if check_date in self.calculate_pre_menstrual_syndrome_days():
            return "Pre-Menstrual Syndrome Window"
        
        return "Regular Day"

def main():
    print("Enter Last period start date\n")
    year = int(input("Enter year: "))
    month = int(input("Enter month: "))
    day = int(input("Enter day: "))
    
    flow_start = date(year, month, day)
    flow_end = flow_start + timedelta(days=5)
    
    calculator = MenstrualCalculator(flow_start, flow_end)
    
    print(f"Flow Duration: {calculator.calculate_flow_duration()} days")
    print(f"Next Period: {calculator.calculate_next_period_date()}")
    print(f"Ovulation Date: {calculator.calculate_ovulation_date()}")
    
    print("\nFertile Window:\n")
    for d in calculator.calculate_fertile_window():
        print(f"{d} -> {calculator.get_fertility_status(d)}")
    
    print("\nSafe Period Days:\n")
    for d in calculator.calculate_safe_period():
        print(d)
    
    print("\nPre-Menstrual Syndrome Period:\n")
    for d in calculator.calculate_pre_menstrual_syndrome_days():
        print(d)

if __name__ == "__main__":
    main()
