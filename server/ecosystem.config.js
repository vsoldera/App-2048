module.exports = {
    apps: [{
        script: "app.js",
        watch: true,
        // Delay between restart
        watch_delay: 1000,
        ignore_watch : ["node_modules", "sessions"]
     }]
};
