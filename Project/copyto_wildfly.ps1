echo "Maven clean install running.."
mvn clean install
echo "Copying EAR to Wildfly deployment"
xcopy /y ".\ear\target\ear-0.0.1.ear" "A:\Wildfly 36\standalone\deployments"
