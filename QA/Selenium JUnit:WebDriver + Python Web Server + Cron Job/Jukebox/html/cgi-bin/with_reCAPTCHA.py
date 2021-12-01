#!/Users/hemanthharshinee/opt/anaconda3/bin/python3

import cgi, cgitb
import pymysql.cursors
import requests
import json

cgitb.enable()
form = cgi.FieldStorage()

song = form.getvalue('song')
cc_number = form.getvalue('cc_number')
response = form.getvalue('g-recaptcha-response')

print('Content-type:text/html\r\n\r\n')
print('<html>')
print('<head>')
print('<title>JukeBox Transaction</title>')
print('</head>')
print('<body>')
print('Song you select: %s' % (song))
print('<br>')
print('Credit card Number is: %s' % (cc_number))
print('</body>')
print('</html>')

def is_human(captcha_response):
    """ Validating recaptcha response from google server
        Returns True captcha test passed for submitted form else returns False.
    """
    secret = "6LckGTYdAAAAAAMnYW_OJyWYx0uRH1tmqk-KiNL1"
    payload = {'response':captcha_response, 'secret':secret}
    response = requests.post("https://www.google.com/recaptcha/api/siteverify", payload)
    response_text = json.loads(response.text)
    return response_text['success']

if is_human(response):
    print("<br>reCAPTCHA succeed!")
    connection = pymysql.connect(host='localhost',
                                 user='root',
                                 password='Redhawk@205',
                                 database='JUKEBOX',
                                 cursorclass=pymysql.cursors.DictCursor)

    cursor = connection.cursor()

    with connection:
        with connection.cursor() as cursor:

            sql = "INSERT INTO `TRANSACTION` (`song`, `cc_number`) VALUES (%s, %s)"
            cursor.execute(sql, (song, cc_number))

        connection.commit()
else:
    print("<br>reCAPTCHA failed!")
