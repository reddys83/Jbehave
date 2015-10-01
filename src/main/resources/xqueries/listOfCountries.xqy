let $countries:= (for $x in collection('current')/country
return <countries>{$x/summary/names/name[type='Country Name']/value}</countries>)

let $info := for $x in $countries
return <result>{$x/value/text()}</result>

return <a>{$info}</a>