#!/Users/hemanthharshinee/opt/anaconda3/bin/python3

import cgi, cgitb
import pymysql.cursors

cgitb.enable()
form = cgi.FieldStorage()

song_placeholder = form.getvalue('song')
cc_number_placeholder = form.getvalue('cc_number')

print('Content-type:text/html\r\n\r\n')
print('<html>')
print('<head>')
print('<title>JukeBox Transaction</title>')
print('</head>')
print('<body>')
print('Song you select: %s' % (song_placeholder))
print('<br>')
print('Credit card Number is: %s' % (cc_number_placeholder))
print('</body>')
print('</html>')

connection = pymysql.connect(host='localhost',
                             user='root',
                             password='Redhawk@205',
                             database='JUKEBOX',
                             cursorclass=pymysql.cursors.DictCursor)

with connection:
    with connection.cursor() as cursor:

        sql = "INSERT INTO `TRANSACTION` (`song`, `cc_number`) VALUES (%s, %s)"
        cursor.execute(sql, (song_placeholder, cc_number_placeholder))

    connection.commit()
