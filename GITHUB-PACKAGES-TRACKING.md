# GitHub Packages tracking

Workflow `.github/workflows/snapshot.yml` is **`workflow_dispatch` only**.

Reason: legacy presentation (was JRebirth 8.x). Properties were bumped to
`org.jrebirth:ria:4.0.0-SNAPSHOT` and `jrebirth.version=12.0.0-SNAPSHOT`, but the
codebase may need compile fixes before enabling `push` CI.

After a successful manual run, switch the workflow `on:` to include `push: branches: [master]`.
