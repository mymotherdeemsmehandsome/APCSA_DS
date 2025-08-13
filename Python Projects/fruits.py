import csv
import re

def format_number(num):
    # Strip whitespace
    num = num.strip()
    
    # Default country code
    country_code = '+1'
    
    # Check if the number has a leading '+'
    match = re.match(r'^\+(\d+)', num)
    if match:
        # Extract and preserve the found country code
        country_code_digits = match.group(1)
        country_code = '+' + country_code_digits
        # Remove the country code part from the original number string
        # This also removes the '+' sign and the country code digits
        remainder = num[len(country_code):]
    else:
        # No leading '+', stick with default +1
        remainder = num

    # Remove all non-digit characters from the remainder
    digits = re.sub(r'\D', '', remainder)
    
    # Take up to 10 digits for the main number (after country code)
    main_digits = digits[:10]

    # Split into parts: area code (3 digits), next (3 digits), last (4 digits)
    a = main_digits[0:3]  # area code
    b = main_digits[3:6]  # next three digits
    c = main_digits[6:10] # last four digits

    # Build the formatted number (include only parts that have digits)
    parts = [p for p in [a, b, c] if p]
    formatted = country_code + ' ' + ' '.join(parts)
    return formatted

# Reading from the CSV file
input_filename = '/Users/michaelchinkov/Downloads/numbers.csv'  # Replace with your actual CSV filename
output_filename = '/Users/michaelchinkov/Documents/Programing Projects/Python Projects/formatted_numbers.csv'  # Where to save the formatted numbers

with open(input_filename, 'r', newline='', encoding='utf-8') as infile, \
     open(output_filename, 'w', newline='', encoding='utf-8') as outfile:
    
    reader = csv.reader(infile)
    writer = csv.writer(outfile)
    
    # If your CSV has headers and multiple columns, adjust accordingly.
    # Assuming the first column is the phone number.
    for row in reader:
        if not row:  # Skip empty lines
            continue
        
        original_number = row[0]
        formatted_number = format_number(original_number)
        
        # Write the original number and formatted number or just the formatted number
        # Here we write only the formatted number for simplicity
        writer.writerow([formatted_number])

print(f"Formatted numbers have been written to {output_filename}")
