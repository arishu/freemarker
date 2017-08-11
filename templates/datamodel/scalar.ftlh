<html>
<head>
<meta charset="UTF-8">
<title>Scalars DataModel Test</title>
</head>
<body>
       <table>
          <thead>
            <tr>
              <th>${name}</th>
              <th>${age}</th>
              <th>${height}</th>
              <th>${married}</th>
            </tr>
          </thead>
          <tbody>
              <tr>
                  <td>${pOne.name}</td>
                  <td>${pOne.age}</td>
                  <td>${pOne.height}</td>
                  <td>${pOne.married?then('已婚', '未婚')}</td>
              </tr>
              <tr>
                  <td>${pTwo.name}</td>
                  <td>${pTwo.age}</td>
                  <td>${pTwo.height}</td>
                  <td>${pTwo.married?then('已婚', '未婚')}</td>
              </tr>
              <tr>
                  <td>${pThree.name}</td>
                  <td>${pThree.age}</td>
                  <td>${pThree.height}</td>
                  <td>${pThree.married?then('已婚', '未婚')}</td>
              </tr>
          </tbody>
       </table>
</body>
</html>