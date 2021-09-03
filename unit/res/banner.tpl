<html>
<head>
    <title>::title::</title>
    <link type="text/css" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300">
    <link rel="shortcut icon" href="office/images/favicon.ico" type="image/x-icon"/>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8;"/>
    <meta http-equiv="refresh" content="30">

    <style>
        html {
            font-family: "Roboto",sans-serif;
        }

        body.minimal {
            margin: 0
        }

        body.card .widget {
            background-color: #FFFFFF;
            border-radius: 2px 2px 2px 2px;
            margin: 0.5rem 0 1rem;
            overflow: hidden;
            position: relative;
            box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.16), 0 2px 10px 0 rgba(0, 0, 0, 0.12);
        }

        .hidden_true {
        	display: none;
        }

        .widget-image {
            display: none;
        }

        body.card .widget .widget-image {
            padding: 10px;
            position: relative;
            display: block;
            border-bottom: 1px solid #efefef;
        }

        .widget-image img {
            border-radius: 2px 2px 0 0;
            bottom: 0;
            left: 0;
            position: relative;
            right: 0;
            top: 0;
            max-height: 100px;
        }

        body.card .widget .widget-content {
            border-radius: 0 0 2px 2px;
            padding: 10px 20px 12px;
        }

        .widget .widget-content .title {
            display: none;
        }

        body.card .widget .widget-content .title {
            color: #212121;
            font-size: large;
            display: block;
        }

        .widget .widget-content p {
            font-size: small;
            margin: 0;
        }

        .widget .widget-content a {
            display: none;
        }

        body.card .widget .widget-content a {
            text-decoration: none;
            font-size: small;
            display: block;
        }

        .widget .widget-message {
            margin: 1px 0 10px;
        }

        .widget .widget-message div {
            font-size: small;
            color: #555;
        }

    </style>
</head>

<body class="minimal">

    <div class="widget hidden_::hasPermissions::">
        <div class="widget-content">
            <div class="widget-message">
    			<div class="no-permissions">::noPermissionsMessage::</div>
            </div>
        </div>
    </div>

    <div class="widget hidden_::noHasPermissions::">
        <div class="widget-content">
            <div class="widget-message">
                <div class="count-active-tasks">::activeTasksMessage::</div>
                <div class="count-active-tasks">::pendingTasksMessage::</div>
            </div>
        </div>
    </div>

</body>
</html>