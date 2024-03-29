import xlsxwriter
# Workbook() takes one, non-optional, argument# which is the filename that we want to create.# The file is present in the working directory.
workbook = xlsxwriter.Workbook("ajay (1).xlsx")
# The workbook object is then used to add new# worksheet via the add_worksheet() method.worksheet = workbook.add_worksheet()  # Defaults to Sheet1.
# Create a new Format object to formats cells# in worksheets using add_format() method .
# The properties of a cell that can be formatted include:# fonts, colors, patterns, borders, alignment and number formatting.# here we create bold format object .bold = workbook.add_format({"bold": 1})
# create a data list .
worksheet=workbook.add_worksheet()
bold=workbook.add_format({'bold':1})
headings = ["Year", "Microsoft", "Alphabet", "Amazon"]
data = [
    [2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017],
    [18.76, 23.15, 16.98, 21.86, 22.07, 12.19, 16.8, 21.2],
    [8.376, 9.706, 10.179, 12.733, 14.136, 16.348, 19.478, 12.662],
    [1.152, 0.631, 0.139, 0.274, 0.241, 0.596, 2.371, 3.033],]
# Write a row of data starting from 'A1'# with bold format .
worksheet.write_row("A1", headings, bold)
# Write a column of data starting from# 'A2', 'B2', 'C2' 'D2' respectively .
worksheet.write_column("A2", data[0])
worksheet.write_column("B2", data[1])
worksheet.write_column("C2", data[2])
worksheet.write_column("D2", data[3])
# Create a chart object that can be added# to a worksheet using add_chart() method.
# here we create a line chart object .
chart = workbook.add_chart({"type": "line"})
# Add a data series to a chart# using add_series method.
# Configure the first series.# = Sheet1!$A$1 is equivalent to ['Sheet1', 0, 0].
# note : spaces is not inserted in b / w# = and Sheet1, Sheet1 and !# if space is inserted it throws warning.
chart.add_series(
    {
        "name": "=Sheet1!$B$1",
        "categories": "=Sheet1!$A$2:$A$9",
        "values": "=Sheet1!$B$2:$B$9",
    })
# Configure a second series.# Note use of alternative syntax to define ranges.# [sheetname, first_row, first_col, last_row, last_col].
chart.add_series(
    {
        "name": ["Sheet1", 0, 2],
        "categories": ["Sheet1", 1, 0, 8, 0],
        "values": ["Sheet1", 1, 2, 8, 2],
    })
# Configure a third series.# Note use of alternative syntax to define ranges.# [sheetname, first_row, first_col, last_row, last_col].
chart.add_series(
    {
        "name": ["Sheet1", 0, 3],
        "categories": ["Sheet1", 1, 1, 8, 1],
        "values": ["Sheet1", 1, 3, 8, 3],
    })
# Add a chart titlechart.set_title({"name": "Company Profit Analysis"})
# Add x-axis labelchart.set_x_axis({"name": "Year"})
# Add y-axis labelchart.set_y_axis({"name": "Profit (in Billions)"})
# Set an Excel chart style.chart.set_style(4)
# add chart to the worksheet with given# offset values at the top-left corner of# a chart is anchored to cell D2 .
worksheet.insert_chart("D2", chart, {"x_offset": 25, "y_offset": 10})
# Finally, close the Excel file# via the close() method.
workbook.close()  
