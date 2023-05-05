# CMPE 172 - Lab #8 Notes

# Submit a Link to to your assigned GitHub Repo for Lab #8
# Screenshots
    + Screenshots of your "full" desktop for each step (as shown above).
        + "Full Desktop Screenshots" are required to ensure your work is your own!
    + Screenshots of your Postman API Tests with Request and Response and API key header
# Lab Notes should include:
    + Any challenges you face while working on this lab (i.e. GKE deployment issues) and how you overcame / solved them.
    + A discussion of what changes would be needed in order to deploy your Starbucks API with MySQL / Cloud SQL.
# Run Starbucks API in Docker
![image1](./images/image1.png)<br/>
![image4](./images/image4.png)<br/>
![image5](./images/image5.png)<br/>
# Run Kong Docker in DB-Less Mode
![image2](./images/image2.png)<br/>
![image3](./images/image3.png)<br/>
![image6](./images/image6.png)<br/>
# Deploy Kong on Google GKE
![image14](./images/image14.png)<br/>
# Create a Service for Starbucks API
# Test Reachability from GKE Jumbox Pod
![image16](./images/image16.png)<br/>
![image18](./images/image18.png)<br/>
# Install Kong GKE Ingress Controller
![image15](./images/image15.png)<br/>
![image12](./images/image12.png)<br/>
# Create an Ingress rule to proxy the Starbucks Service
![image8](./images/image8.png)<br/>
![image9](./images/image9.png)<br/>
# Test Kong API Ping Endpoint
![image7](./images/image7.png)<br/>
# Add Kong Key-Auth PlugIn
# Configure an API Client Key
![image10](./images/image10.png)<br/>
# Apply API Key Credentials to API Client
![image11](./images/image11.png)<br/>
# Test Your API Against Kong via Public IP of Load Balancer
![image17](./images/image17.png)<br/>
![image13](./images/image13.png)<br/>