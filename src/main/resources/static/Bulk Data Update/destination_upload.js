const fs = require("fs");

// Read destinations.json
const destinations = JSON.parse(
  fs.readFileSync("./destinations.json", "utf8")
);

const URL = "http://localhost:8080/api/destination/save";

(async () => {
  console.log(`Uploading ${destinations.length} destinations...\n`);

  for (const destination of destinations) {
    try {
      const response = await fetch(URL, {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(destination)
      });

      if (response.ok) {
        console.log(`✔ ${destination.code} (${response.status})`);
      } else {
        const error = await response.text();
        console.error(`✖ ${destination.code} (${response.status})`);
        console.error(error);
      }
    } catch (err) {
      console.error(`✖ ${destination.code}: ${err.message}`);
    }
  }

  console.log("\nFinished.");
})();